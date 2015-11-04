module.exports = function ( grunt ) {

	// Load required Grunt tasks.
	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.loadNpmTasks('grunt-bump');
	grunt.loadNpmTasks('grunt-karma');
	grunt.loadNpmTasks('grunt-ng-annotate');
	grunt.loadNpmTasks('grunt-html2js');

	// Load configuration.
	var userConfig = require('./build.config.js');

	var taskConfig = {
		pkg: grunt.file.readJSON('package.json'),

		meta: {
			banner:
				'/**\n' +
				' * <%= pkg.name %> - v<%= pkg.version %> - <%= grunt.template.today("yyyy-mm-dd") %>\n' +
				' * <%= pkg.homepage %>\n' +
				' *\n' +
				' * Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author %>\n' +
				' * Licensed <%= pkg.licenses.type %> <<%= pkg.licenses.url %>>\n' +
				' */\n'
		},

		bump: {
			options: {
				files: [
					'package.json',
					'bower.json'
				],
				commit: true,
				commitMessage: 'Release %VERSION%',
				commitFiles: [
					'package.json',
					'bower.json'
				],
				createTag: true,
				tagName: '<%= pkg.name %>-RC-%VERSION%',
				push: false,
				pushTo: 'origin'
			}
		},

		clean: [
			'<%= build_dir %>',
			'<%= compile_dir %>'
		],

		copy: {
			build_app_assets: {
				files: [
					{
						src: [ '**' ],
						dest: '<%= build_dir %>/assets/',
						cwd: 'src/assets',
						expand: true
					}
				]
			},

			build_vendor_assets: {
				files: [
					{
						src: [ '<%= vendor_files.assets %>' ],
						dest: '<%= build_dir %>/assets/',
						cwd: '.',
						expand: true
					}
				]
			},

			build_appjs: {
				files: [
					{
						src: [ '<%= app_files.js %>' ],
						dest: '<%= build_dir %>/',
						cwd: '.',
						expand: true
					}
				]
			},

			build_vendorjs: {
				files: [
					{
						src: [ '<%= vendor_files.js %>' ],
						dest: '<%= build_dir %>/',
						cwd: '.',
						expand: true
					}
				]
			},

			build_vendorcss: {
				files: [
					{
						src: [ '<%= vendor_files.css %>' ],
						dest: '<%= build_dir %>/',
						cwd: '.',
						expand: true
					}
				]
			},

			compile_assets: {
				files: [
					{
						src: [ '**' ],
						dest: '<%= compile_dir %>/assets',
						cwd: '<%= build_dir %>/assets',
						expand: true
					},
					{
						src: [ '<%= vendor_files.css %>' ],
						dest: '<%= compile_dir %>/',
						cwd: '.',
						expand: true
					}
				]
			}
		},

		concat: {
			build_css: {
				src: [
					'<%= vendor_files.css %>',
					'<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css'
				],
				dest: '<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css'
			},

			compile_js: {
				options: {
					banner: '<%= meta.banner %>'
				},
				src: [ 
					'<%= vendor_files.js %>', 
					'module.prefix', 
					'<%= build_dir %>/src/**/*.js', 
					'<%= html2js.app.dest %>', 
					'<%= html2js.common.dest %>', 
					'module.suffix' 
				],
				dest: '<%= compile_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.js'
			}
		},

		ngAnnotate: {
			compile: {
				files: [
					{
						src: [ '<%= app_files.js %>' ],
						cwd: '<%= build_dir %>',
						dest: '<%= build_dir %>',
						expand: true
					}
				]
			}
		},

		uglify: {
			compile: {
				options: {
					banner: '<%= meta.banner %>'
				},
				files: {
					'<%= concat.compile_js.dest %>': '<%= concat.compile_js.dest %>'
				}
			}
		},

		less: {
			build: {
				files: {
					'<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css': '<%= app_files.less %>'
				}
			},
			compile: {
				files: {
					'<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css': '<%= app_files.less %>'
				},
				options: {
					cleancss: true,
					compress: true
				}
			}
		},

		jshint: {
			src: [ 
				'<%= app_files.js %>'
			],
			test: [
				'<%= app_files.jsunit %>'
			],
			gruntfile: [
				'Gruntfile.js'
			],
			options: {
				curly: true,
				immed: true,
				newcap: true,
				noarg: true,
				sub: true,
				boss: true,
				eqnull: true
			},
			globals: {}
		},

		html2js: {
			app: {
				options: {
					base: 'src/app'
				},
				src: [ '<%= app_files.atpl %>' ],
				dest: '<%= build_dir %>/templates-app.js'
			},

			common: {
				options: {
					base: 'src/common'
				},
				src: [ '<%= app_files.ctpl %>' ],
				dest: '<%= build_dir %>/templates-common.js'
			}
		},

		karma: {
			options: {
				configFile: '<%= build_dir %>/karma-unit.js'
			},
			unit: {
				port: 5000,
				background: true
			},
			continuous: {
				singleRun: true
			}
		},

		index: {
			build: {
				dir: '<%= build_dir %>',
				src: [
					'<%= vendor_files.js %>',
					'<%= build_dir %>/src/**/*.js',
					'<%= html2js.common.dest %>',
					'<%= html2js.app.dest %>',
					'<%= vendor_files.css %>',
					'<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css'
				]
			},

			compile: {
				dir: '<%= compile_dir %>',
				src: [
					'<%= concat.compile_js.dest %>',
					'<%= vendor_files.css %>',
					'<%= build_dir %>/assets/<%= pkg.name %>-<%= pkg.version %>.css'
				]
			}
		},

		karmaconfig: {
			unit: {
				dir: '<%= build_dir %>',
				src: [ 
					'<%= vendor_files.js %>',
					'<%= html2js.app.dest %>',
					'<%= html2js.common.dest %>',
					'<%= test_files.js %>'
				]
			}
		},

		delta: {
			/**
			 * By default, we want the Live Reload to work for all tasks; this is
			 * overridden in some tasks (like this file) where browser resources are
			 * unaffected. It runs by default on port 35729, which your browser
			 * plugin should auto-detect.
			 */
			options: {
				livereload: 7000,
				event: [ 'all' ]
			},

			gruntfile: {
				files: 'Gruntfile.js',
				tasks: [ 'jshint:gruntfile' ],
			},

			jssrc: {
				files: [ 
					'<%= app_files.js %>'
				],
				tasks: [ 'jshint:src', 'karma:unit:run', 'copy:build_appjs' ]
			},

			assets: {
				files: [ 
					'src/assets/**/*'
				],
				tasks: [ 'copy:build_app_assets', 'copy:build_vendor_assets' ]
			},

			html: {
				files: [ '<%= app_files.html %>' ],
				tasks: [ 'index:build' ]
			},

			tpls: {
				files: [ 
					'<%= app_files.atpl %>', 
					'<%= app_files.ctpl %>'
				],
				tasks: [ 'html2js' ]
			},

			less: {
				files: [ 'src/**/*.less' ],
				tasks: [ 'less:build' ]
			},

			jsunit: {
				files: [
					'<%= app_files.jsunit %>'
				],
				tasks: [ 'jshint:test', 'karma:unit:run' ],
				options: {
					livereload: false
				}
			}
		}
	};

	grunt.initConfig( grunt.util._.extend( taskConfig, userConfig ) );

	/**
	 * In order to make it safe to just compile or copy *only* what was changed,
	 * we need to ensure we are starting from a clean, fresh build. So we rename
	 * the `watch` task to `delta` (that's why the configuration var above is
	 * `delta`) and then add a new task called `watch` that does a clean build
	 * before watching for changes.
	 */
	grunt.renameTask( 'watch', 'delta' );
	grunt.registerTask( 'watch', [ 'build', 'delta' ] );
	grunt.registerTask( 'watch-test', [ 'build-test', 'karma:unit', 'delta' ] );

	grunt.registerTask( 'default', [ 'build', 'compile' ] );

	grunt.registerTask( 'build-test', [ 'build', 'karmaconfig', 'karma:continuous' ]);
	grunt.registerTask( 'build', [
		'clean', 'html2js', 'jshint', 'less:build',
		'concat:build_css', 'copy:build_app_assets', 'copy:build_vendor_assets',
		'copy:build_appjs', 'copy:build_vendorjs', 'copy:build_vendorcss', 'index:build'
	]);

	grunt.registerTask( 'compile', [
		'less:compile', 'copy:compile_assets', 'ngAnnotate', 'concat:compile_js', 'uglify', 'index:compile'
	]);

	function filterForJS ( files ) {
		return files.filter( function ( file ) {
			return file.match( /\.js$/ );
		});
	}

	function filterForCSS ( files ) {
		return files.filter( function ( file ) {
			return file.match( /\.css$/ );
		});
	}

	/** 
	 * The index.html template includes the stylesheet and javascript sources
	 * based on dynamic names calculated in this Gruntfile. This task assembles
	 * the list into variables for the template to use and then runs the
	 * compilation.
	 */
	grunt.registerMultiTask( 'index', 'Process index.html template', function () {
		var dirRE = new RegExp( '^('+grunt.config('build_dir')+'|'+grunt.config('compile_dir')+')\/', 'g' );
		var jsFiles = filterForJS( this.filesSrc ).map( function ( file ) {
			return file.replace( dirRE, '' );
		});
		var cssFiles = filterForCSS( this.filesSrc ).map( function ( file ) {
			return file.replace( dirRE, '' );
		});

		grunt.file.copy('src/index.html', this.data.dir + '/index.html', { 
			process: function ( contents, path ) {
				return grunt.template.process( contents, {
					data: {
						scripts: jsFiles,
						styles: cssFiles,
						version: grunt.config( 'pkg.version' )
					}
				});
			}
		});
	});

	/**
	 * In order to avoid having to specify manually the files needed for karma to
	 * run, we use grunt to manage the list for us. The `karma/*` files are
	 * compiled as grunt templates for use by Karma. Yay!
	 */
	grunt.registerMultiTask( 'karmaconfig', 'Process karma config templates', function () {
		var jsFiles = filterForJS( this.filesSrc );
		
		grunt.file.copy( 'karma/karma-unit.tpl.js', grunt.config( 'build_dir' ) + '/karma-unit.js', { 
			process: function ( contents, path ) {
				return grunt.template.process( contents, {
					data: {
						scripts: jsFiles
					}
				});
			}
		});
	});

};
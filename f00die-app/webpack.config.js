const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const UglifyJSPPlugin = require('uglifyjs-webpack-plugin');

module.exports = {
 mode: 'development',
 context: path.resolve(__dirname, './src'),
 entry: {
   polyfills: './polyfills.ts',
   styles: './styles.css',
   app: './app/app.module.ts',
 },
 output: {
   path: path.resolve(__dirname, './dist'),
   filename: '[name].js',
 },
 devServer: {
	proxy: {
	'/api': {
		target: 'http://localhost:8081'
  },
  '/user': {
		target: 'http://localhost:8080'
  }
  
	}
},
 module: {
   rules: [
     { test: /\.ts/, use: ['ts-loader', 'angular2-template-loader'] },
     { test: /\.html$/, use: 'raw-loader' },
     { test: /\.css$/, use: ['to-string-loader', 'style-loader', 'css-loader'] },
   ]
 },
 resolve: {
  extensions: [".js", ".ts", ".html", ".css", ".ico"],
 },
 devtool: 'source-map',
 plugins: [
   new webpack.ContextReplacementPlugin(
    /angular(\\|\/)core(\\|\/)/, path.resolve(__dirname, './src')
   ),
   new webpack.DefinePlugin({
    'process.env' : {
      NODE_ENV: JSON.stringify('development')
    }
   }),
   new HtmlWebpackPlugin({
     title: 'Foodie App',
     template: 'index.html'
   }),
   new UglifyJSPPlugin(
     {sourceMap : true}
   )
  ]
};

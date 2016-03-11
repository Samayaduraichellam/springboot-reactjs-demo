
var path = require ('path');

var clientSrcPath = path.resolve (__dirname, 'frontend');
var serverSrcPath = path.resolve (__dirname, 'src/main/resources/static');


module.exports = {

    entry: clientSrcPath + '/main.js',

    output: {
        path: serverSrcPath,
        filename: 'app.bundle.js'
    },

    module: {
        loaders: [
            {test: /.js$/, exclude: /node_modules/, loader: 'babel'}
        ]
    }
};

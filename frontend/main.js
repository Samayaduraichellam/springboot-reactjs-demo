
import React from 'react'
import { renderToString } from 'react-dom/server'
import App from './App'


global.renderServer = (products) => {
    return renderToString (
        <App products={products} />
    )
};

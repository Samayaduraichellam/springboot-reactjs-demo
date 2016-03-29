
import React from 'react'
import { renderToString } from 'react-dom/server'
import App from './App'


global.renderServer = (products, sortBy) => {
    const jsProducts = Java.from (products);
    return renderToString (
        <App products={jsProducts} sortBy={sortBy} />
    )
};

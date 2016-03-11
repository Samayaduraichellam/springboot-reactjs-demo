
import React from 'react'
import ProductList from './product/ProductList'


const App = ({
    products
}) => (
    <div>
        <h1>Aweseome Product List</h1>
        <ProductList products={products} />
    </div>
);

export default App;



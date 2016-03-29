
import React from 'react'
import ProductFilter from './product/ProductFilter'
import ProductList from './product/ProductList'


const App = ({
    sortBy,
    products
}) => (
    <div>
        <h1>Aweseome Product List</h1>
        <ProductFilter sortBy={sortBy} />
        <ProductList products={products} />
    </div>
);

export default App;



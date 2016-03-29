
import React from 'react'
import ProductFilter from './product/ProductFilter'
import ProductList from './product/ProductList'


class App extends React.Component {

    render () {

        const {
            sortBy,
            products
        } = this.props;

        return (
            <div>
                <h1>Aweseome Product List</h1>
                <ProductFilter sortBy={sortBy}/>
                <ProductList products={products}/>
            </div>
        );
    }
}

export default App;



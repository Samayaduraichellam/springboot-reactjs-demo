
import React from 'react'
import ProductFilter from './product/ProductFilter'
import ProductList from './product/ProductList'


class App extends React.Component {

    constructor (props) {
        super (props);
        this.state = {
            sortBy  : props.sortBy,
            products: props.products
        }
    }

    render () {

        const {
            sortBy,
            products
        } = this.state;

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



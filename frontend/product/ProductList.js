
import React from 'react'


const ProductList = ({
    products = []
}) => (
    <div>
        <ul>
        {products.map (({name, value}, i) => (
            <li key={i}>
                <b>{name}</b>&nbsp;<span>{value}&nbsp;EUR</span>
            </li>
        ))}
        </ul>
    </div>
);

export default ProductList;

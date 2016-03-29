
import React from 'react'


const ProductFilter = ({
    sortBy
}) => (
    <form action="/" method="get">
        <b>sort by</b>
        <FilterItem label="Name" value="name" checked={sortBy === 'name'} />
        <FilterItem label="Price" value="price" checked={sortBy === 'price'} />
        <button type="submit">submit</button>
    </form>
);

const FilterItem = ({
    label,
    value,
    checked
}) => (
    <span>
        <input type="radio" name="sort" value={value} id={`sort-${value}`} defaultChecked={checked}></input>
        <label htmlFor={`sort-${value}`}>{label}</label>
    </span>
);

export default ProductFilter;

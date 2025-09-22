import React from "react";
import {
  MagnifyingGlassIcon,
  AdjustmentsHorizontalIcon,
  PlusIcon,
  ArrowDownTrayIcon,
} from "@heroicons/react/24/outline";
import { Link } from "react-router-dom";

const products = [
  {
    id: 1,
    name: "ASUS ROG Gaming Laptop",
    image: "https://via.placeholder.com/50",
    category: "Laptop",
    brand: "ASUS",
    price: "$2,199",
    stock: "Out of Stock",
    createdAt: "01 Dec, 2027",
  },
];

const ProductList = () => {
  return (
    <div>
      {/* Page Header */}
      <div className="flex justify-between items-center mb-6">
        <div>
          <h1 className="text-2xl font-bold text-gray-900">Products</h1>
          <p className="text-sm text-gray-500">Home / Products</p>
        </div>
        <div className="flex space-x-2">
          <button className="flex items-center px-4 py-2 bg-white text-gray-700 border border-gray-300 rounded-lg shadow-sm hover:bg-gray-50">
            <ArrowDownTrayIcon className="h-5 w-5 mr-2" />
            Export
          </button>
          <button className="flex items-center px-4 py-2 bg-blue-600 text-white rounded-lg shadow-sm hover:bg-blue-700">
            <PlusIcon className="h-5 w-5 mr-2" />
            <Link to={"/dashboard/add-product"}>Add Product</Link>
          </button>
        </div>
      </div>

      {/* Products List Section */}
      <div className="bg-white rounded-lg shadow-md p-6">
        <div className="flex justify-between items-center mb-4">
          <div>
            <h3 className="text-lg font-semibold text-gray-900">
              Products List
            </h3>
            <p className="text-sm text-gray-500">
              Track your store's progress to boost your sales.
            </p>
          </div>
          <div className="flex space-x-2">
            <div className="relative">
              <input
                type="text"
                placeholder="Search..."
                className="w-48 pl-8 pr-4 py-2 rounded-lg text-sm border border-gray-300 focus:outline-none"
              />
              <MagnifyingGlassIcon className="h-4 w-4 text-gray-400 absolute left-2 top-1/2 transform -translate-y-1/2" />
            </div>
            <button className="flex items-center px-4 py-2 bg-white text-gray-700 border border-gray-300 rounded-lg shadow-sm hover:bg-gray-50">
              <AdjustmentsHorizontalIcon className="h-5 w-5 mr-2" />
              Filter
            </button>
          </div>
        </div>

        {/* Product Table */}
        <div className="overflow-x-auto">
          <table className="min-w-full divide-y divide-gray-200">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-6 py-3 text-left">
                  <input type="checkbox" className="rounded text-blue-600" />
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Products
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Category
                </th>
                {/* ... other headers */}
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-gray-200">
              {products.map((product) => (
                <tr key={product.id}>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <input type="checkbox" className="rounded text-blue-600" />
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap flex items-center">
                    <img
                      src={product.image}
                      alt={product.name}
                      className="h-10 w-10 rounded-full mr-4"
                    />
                    <span className="text-sm font-medium text-gray-900">
                      {product.name}
                    </span>
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    {product.category}
                  </td>
                  {/* ... other data cells */}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default ProductList;

import React from 'react'

const HomesectionCard = ({ product }) => {
  return (
    <div className="cursor-pointer flex flex-col items-center bg-white p-4 rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3">
      <div className="h-[13rem] w-[10rem]">
        <img
          className="object-cover object-top w-full h-full"
          src={product.imageUrl}
          alt=""
        />
      </div>
      <div className="p-4">
        <h3 className="text-lg font-semibold text-gray-800 mb-2">
          {product.brand}
        </h3>
        <p className="text-gray-600 text-sm mt-2">{product.title}</p>
      </div>
    </div>
  );
}

export default HomesectionCard
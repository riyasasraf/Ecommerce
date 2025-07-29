import React from 'react'
import  './Productcard.css'

  const Productcard = ({ Product}) => {
    return (
      <div className="Productcard w-[15rem] m-3 transition-all cursor-pointer">
        <div className="h-[20rem]">
          <img
            className=" h-full w-full  object-cover object-left-top"
            src={Product.imageUrl}
            alt=""
          />
        </div>
        <div className="textPart bg-white p-3">
          <div className="">
            <p className="font-bold opacity-60">{Product.brand}</p>
            <p className="">{Product.title}</p>
          </div>
          <div className="flex items-center space-x-2">
            <p className="font-semibold">{Product.discountedPrice}</p>
            <p className="line-through opacity-50">{Product.price}</p>
            <p className="text-green-500 font-semibold">
              {Product.discountPersent}% off
            </p>
          </div>
        </div>
      </div>
    );
}

export default Productcard
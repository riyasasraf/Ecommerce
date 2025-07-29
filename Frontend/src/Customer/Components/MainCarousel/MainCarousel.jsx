// MainCarousel.jsx
import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

const homeCarousalData = [
  {
    image:
      "https://www.louisvuitton.com/images/is/image/lv/W_BC_ShowFW25_July25_01_DII.jpg?wid=2400",
  },
  {
    image:
      "https://www.louisvuitton.com/images/is/image/lv/W_BC_ShowFW25_July25_06_DI3.jpg?wid=2400",
  },
  {
    image:
      "https://ap.louisvuitton.com/images/is/image//content/dam/lv/editorial-content/New-Homepage/2025/central/collections/women-lg/WLG_EXPRESS_WW_HP_push_DI3.jpg?wid=2400",
  },
  {
    image:
      "https://ap.louisvuitton.com/images/is/image//content/dam/lv/editorial-content/New-Homepage/2025/central/collections/men-lg/Men_Bags_Shopper_Tote_2507_WW_HP_Push__DI3.jpg?wid=2400",
  },
];

const MainCarousel = () => {
  return (
    <AliceCarousel autoPlay autoPlayInterval={1000} infinite disableButtonsControls>
      {homeCarousalData.map((item, index) => (
        <img
          key={index}
          className="cursor-pointer w-full h-[500px] object-contain"
          src={item.image}
          alt={`carousel-${index}`}
        />
      ))}
    </AliceCarousel>
  );
};

export default MainCarousel;

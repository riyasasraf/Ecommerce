import React, { useRef, useState } from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import HomeSectionCard from "../HomeSectionCard/HomesectionCard";
import { Button } from "@mui/material";
import KeyboardArrowRightIcon from "@mui/icons-material/KeyboardArrowRight";

const HomeSectionCarousal = ({data, sectionName}) => {
  const [activeIndex, setActiveIndex] = useState(0);
  const carouselRef = useRef(null); // ✅ Create a ref for AliceCarousel

  const responsive = {
    0: { items: 1 },
    500: { items: 2 },
    720: { items: 3 },
    1024: { items: 4.5 },
  };

  // ✅ Use the carousel's built-in slide methods
  const sLideprev = () => {
    if (carouselRef.current) {
      carouselRef.current.slidePrev();
    }
  };

  const sLidenext = () => {
    if (carouselRef.current) {
      carouselRef.current.slideNext();
    }
  };

  const syncActiveIndex = ({ item }) => setActiveIndex(item);

  const items = data
    .slice(0, 10)
    .map((item, index) => <HomeSectionCard key={index} product={item} />);

  return (
    <div className="relative px-4 lg:px-8">
      <div className="relative p-5">
        <h1 className="p-3 font-bold text-xl">{sectionName}</h1>
        <AliceCarousel
          ref={carouselRef} // ✅ attach ref here
          items={items}
          disableButtonsControls
          disableDotsControls
          responsive={responsive}
          onSlideChanged={syncActiveIndex}
        />

        {/* Next button */}
        {activeIndex < items.length - 4 && (
          <Button
            onClick={sLidenext}
            variant="contained"
            className="z-50 bg-white"
            sx={{
              position: "absolute",
              top: "12rem",
              right: "0rem",
              transform: "translateX(50%) rotate(90deg)",
            }}
            color="white"
            aria-label="next"
          >
            <KeyboardArrowRightIcon
              sx={{ transform: "rotate(-90deg)", color: "black" }}
            />
          </Button>
        )}

        {/* Prev button */}
        {activeIndex !== 0 && (
          <Button
            onClick={sLideprev}
            variant="contained"
            className="z-50 bg-white"
            sx={{
              position: "absolute",
              top: "12rem",
              left: "0rem",
              transform: "translateX(-50%) rotate(-90deg)",
            }}
            color="white"
            aria-label="prev"
          >
            <KeyboardArrowRightIcon
              sx={{ transform: "rotate(-90deg)", color: "black" }}
            />
          </Button>
        )}
      </div>
    </div>
  );
};

export default HomeSectionCarousal;

import React from 'react'
import MainCarousel from "../Components/MainCarousel/MainCarousel.jsx";
import HomeSectionCarousal from "../Components/HomeSectionCarousal/HomeSectionCarousal.jsx";
import { mens_kurta } from "../data/Mens_kurthas";
import { Mens_shoes } from '../data/Mens_shoes.js';
import { mens_shirts } from '../data/Mens_shirts.js';
import { womens_saree } from '../data/womens_saree.js'; 
import { womens_dress } from '../data/womens_dress.js';
import Footer from '../Components/Footer/Footer.jsx';


const HomePage = () => {
  return (
    <div>
      <div>
        <MainCarousel />
      </div>
      <div className="space-y-10 py-10 flex flex-col justify-center px-3.5 lg:px-10 ">
        <HomeSectionCarousal data={mens_kurta} sectionName="Men's Kurta" />
        <HomeSectionCarousal data={Mens_shoes} sectionName="Men's Shoes" />
        <HomeSectionCarousal data={mens_shirts} sectionName="Men's Shirts" />
        <HomeSectionCarousal data={womens_saree} sectionName="Women's Saree" />
        <HomeSectionCarousal data={womens_dress} sectionName="Women's Dress" />
      </div>
      
    </div>
  );
}

export default HomePage
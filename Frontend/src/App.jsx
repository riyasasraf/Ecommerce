import React from 'react'
import Navigation from './Customer/Components/Navigation/Navigation.jsx'

import HomePage from './Customer/Pages/HomePage.jsx';
import Product from './Customer/Products/Product.jsx';
import Footer from './Customer/Components/Footer/Footer.jsx';

const App = () => {
  return (
    <>
      <div>
        <Navigation />
        <div>
          {/* <HomePage /> */}
          <Product />
        </div>
        <div>
          <Footer />
        </div>
      </div>
    </>
  );
}

export default App
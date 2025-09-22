import React from "react";
import { Route, Routes ,Navigate} from "react-router-dom";

import Navigation from "./Customer/Components/Navigation/Navigation.jsx";
import Footer from "./Customer/Components/Footer/Footer.jsx";

import HomePage from "./Customer/Pages/HomePage.jsx";
import Product from "./Customer/Products/Product.jsx";
import ProductDetails from "./Customer/Components/ProducuDetails/ProductDetails.jsx";
import DashBoard from "./Business/DashBoard/DashBoard.jsx";
import ProductList from "./Business/DashBoard/DashBoardItems/ProductList.jsx";
import AddProductForm from "./Business/DashBoard/DashBoardItems/AddProductForm.jsx";
const App = () => {
  return (
    <>
      <Navigation />

      <main>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/dashboard" element={<DashBoard />}>
            <Route index element={<Navigate to="products" replace />} />
            <Route path="products" element={<ProductList />} />
            <Route path="add-product" element={<AddProductForm />} />
          </Route>
          <Route path="/product/:id" element={<ProductDetails />} />
        </Routes>
      </main>

      <Footer />
    </>
  );
};

export default App;

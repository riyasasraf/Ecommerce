import {
  ArrowUpTrayIcon,
  MinusIcon,
  PlusIcon,
} from "@heroicons/react/24/outline";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getCategories, getSubcategories } from "../../../apis/category";

const AddProductForm = () => {
  // State for Product Description section
  const [productName, setProductName] = useState("");
  const [category, setCategory] = useState(""); // selected category ID
  const [categories, setCategories] = useState([]); // list of categories
  const [subCategory, setsubCategory] = useState(""); // selected category ID
  const [subCategories, setsubCategories] = useState([]);
  const [brand, setBrand] = useState("");
  const [color, setColor] = useState("");
  const [weight, setWeight] = useState("");
  const [length, setLength] = useState("");
  const [width, setWidth] = useState("");
  const [description, setDescription] = useState("");
  const [stockQuantity, setStockQuantity] = useState(1);
  const [availabilityStatus, setAvailabilityStatus] = useState("");

  const handleStockQuantityChange = (type) => {
    if (type === "increment") {
      setStockQuantity(stockQuantity + 1);
    } else if (type === "decrement" && stockQuantity > 0) {
      setStockQuantity(stockQuantity - 1);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = {
      productName,
      category,
      brand,
      color,
      weight,
      length,
      width,
      description,
      stockQuantity,
      availabilityStatus,
    };
    console.log("Form Submitted:", formData);
    // You would typically send this data to an API endpoint here
  };
  useEffect(() => {
    const controller = new AbortController();
    const { signal } = controller;

    async function load() {
      try {
        const data = await getCategories(signal);
        setCategories(data);
      } catch (err) {
        if (err.name === "CanceledError" || err.name === "AbortError") return;
        console.error("Failed to load categories", err);
      }
    }
    load();

    return () => controller.abort();
  }, []);
  
  useEffect(() => {
    if (!category) return;

    const controller = new AbortController();
    const { signal } = controller;

    async function loadSubcategories() {
      try {
        const data = await getSubcategories(category, signal); // API: /categories/:id/subcategories
        setsubCategories(data);
        setsubCategory(""); 
      } catch (err) {
        console.error("Failed to load subcategories", err);
      }
    }

    loadSubcategories();
    return () => controller.abort();
  }, [category]);


  return (
    <div className="bg-gray-100 min-h-screen p-8">
      {/* Page Header */}
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold text-gray-900">Add Product</h1>
        <div className="text-sm text-gray-500">
          <Link to="/" className="hover:underline">
            Home
          </Link>{" "}
          / Add Product
        </div>
      </div>

      <form onSubmit={handleSubmit} className="space-y-6">
        {/* Products Description Section */}
        <div className="bg-white rounded-lg shadow-md p-6">
          <h2 className="text-xl font-semibold text-gray-800 mb-4">
            Products Description
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-x-6 gap-y-4">
            <div>
              <label
                htmlFor="productName"
                className="block text-sm font-medium text-gray-700"
              >
                Product Name
              </label>
              <input
                type="text"
                id="productName"
                value={productName}
                onChange={(e) => setProductName(e.target.value)}
                placeholder="Enter product name"
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  shadow-sm focus:border-blue-500 focus:ring-blue-500"
              />
            </div>
            <div>
              <label
                htmlFor="category"
                className="block text-sm font-medium text-gray-700"
              >
                Category
              </label>
              <select
                id="category"
                value={category}
                onChange={(e) => setCategory(e.target.value)}
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              >
                <option value="">Select Category</option>
                {categories.map((c) => (
                  <option key={c.id} value={c.id}>
                    {c.name}
                  </option>
                ))}
              </select>
            </div>
            <div>
              <label
                htmlFor="subcategory"
                className="block text-sm font-medium text-gray-700"
              >
                Sub Category
              </label>
              <select
                id="subcategory"
                value={subCategory}
                onChange={(e) => setsubCategory(e.target.value)}
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              >
                <option value="">Select subcategory</option>
                {subCategories.map((c) => (
                  <option key={c.id} value={c.id}>
                    {c.name}
                  </option>
                ))}
              </select>
            </div>
            <div>
              <label
                htmlFor="brand"
                className="block text-sm font-medium text-gray-700"
              >
                Brand
              </label>
              <select
                id="brand"
                value={brand}
                onChange={(e) => setBrand(e.target.value)}
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              >
                <option value="">Select Brand</option>
                <option value="apple">Apple</option>
                <option value="samsung">Samsung</option>
                {/* Add more brands */}
              </select>
            </div>
            <div>
              <label
                htmlFor="color"
                className="block text-sm font-medium text-gray-700"
              >
                Color
              </label>
              <select
                id="color"
                value={color}
                onChange={(e) => setColor(e.target.value)}
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              >
                <option value="">Select color</option>
                <option value="black">Black</option>
                <option value="white">White</option>
                {/* Add more colors */}
              </select>
            </div>
            <div className="col-span-1 md:col-span-2">
              <div className="grid grid-cols-3 gap-x-4">
                <div>
                  <label
                    htmlFor="weight"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Weight (kg)
                  </label>
                  <input
                    type="number"
                    id="weight"
                    value={weight}
                    onChange={(e) => setWeight(e.target.value)}
                    placeholder="e.g., 15"
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
                  />
                </div>
                <div>
                  <label
                    htmlFor="length"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Length (cm)
                  </label>
                  <input
                    type="number"
                    id="length"
                    value={length}
                    onChange={(e) => setLength(e.target.value)}
                    placeholder="e.g., 120"
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  shadow-sm focus:border-blue-500 focus:ring-blue-500"
                  />
                </div>
                <div>
                  <label
                    htmlFor="width"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Width (cm)
                  </label>
                  <input
                    type="number"
                    id="width"
                    value={width}
                    onChange={(e) => setWidth(e.target.value)}
                    placeholder="e.g., 23"
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  shadow-sm focus:border-blue-500 focus:ring-blue-500"
                  />
                </div>
              </div>
            </div>
            <div className="col-span-1 md:col-span-2">
              <label
                htmlFor="description"
                className="block text-sm font-medium text-gray-700"
              >
                Description
              </label>
              <textarea
                id="description"
                rows="3"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Receipt info (optional)"
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              ></textarea>
            </div>
          </div>
        </div>

        {/* Pricing & Availability Section */}
        <div className="bg-white rounded-lg shadow-md p-6">
          <h2 className="text-xl font-semibold text-gray-800 mb-4">
            Pricing & Availability
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-x-6 gap-y-4">
            <div className="col-span-1 md:col-span-2">
              <div className="grid grid-cols-3 gap-x-4">
                <div>
                  <label
                    htmlFor="priceWeight"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Weight (kg)
                  </label>
                  <input
                    type="number"
                    id="priceWeight"
                    defaultValue={15}
                    disabled
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  bg-gray-50 shadow-sm focus:ring-0"
                  />
                </div>
                <div>
                  <label
                    htmlFor="priceLength"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Length (cm)
                  </label>
                  <input
                    type="number"
                    id="priceLength"
                    defaultValue={120}
                    disabled
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  bg-gray-50 shadow-sm focus:ring-0"
                  />
                </div>
                <div>
                  <label
                    htmlFor="priceWidth"
                    className="block text-sm font-medium text-gray-700"
                  >
                    Width (cm)
                  </label>
                  <input
                    type="number"
                    id="priceWidth"
                    defaultValue={23}
                    disabled
                    className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md  bg-gray-50 shadow-sm focus:ring-0"
                  />
                </div>
              </div>
            </div>
            <div className="grid grid-cols-2 gap-x-4">
              <div>
                <label
                  htmlFor="stockQuantity"
                  className="block text-sm font-medium text-gray-700"
                >
                  Stock Quantity
                </label>
                <div className="mt-1 flex rounded-md shadow-sm">
                  <button
                    type="button"
                    onClick={() => handleStockQuantityChange("decrement")}
                    className="inline-flex items-center rounded-l-md border border-r-0 border-gray-300 bg-gray-50 px-3 text-gray-500 hover:bg-gray-100"
                  >
                    <MinusIcon className="h-5 w-5" />
                  </button>
                  <input
                    type="number"
                    id="stockQuantity"
                    value={stockQuantity}
                    onChange={(e) => setStockQuantity(Number(e.target.value))}
                    className="block w-full border border-gray-400 text-center focus:border-blue-500 focus:ring-blue-500"
                  />
                  <button
                    type="button"
                    onClick={() => handleStockQuantityChange("increment")}
                    className="inline-flex items-center rounded-r-md border border-l-0 border-gray-300 bg-gray-50 px-3 text-gray-500 hover:bg-gray-100"
                  >
                    <PlusIcon className="h-5 w-5" />
                  </button>
                </div>
              </div>
            </div>
            <div>
              <label
                htmlFor="availabilityStatus"
                className="block text-sm font-medium text-gray-700"
              >
                Availability Status
              </label>
              <select
                id="availabilityStatus"
                value={availabilityStatus}
                onChange={(e) => setAvailabilityStatus(e.target.value)}
                className="mt-1 block w-full border p-1.5 border-gray-400 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
              >
                <option value="">Select Availability</option>
                <option value="in-stock">In Stock</option>
                <option value="out-of-stock">Out of Stock</option>
              </select>
            </div>
          </div>
        </div>

        {/* Products Images Section */}
        <div className="bg-white rounded-lg shadow-md p-6">
          <h2 className="text-xl font-semibold text-gray-800 mb-4">
            Products Images
          </h2>
          <div className="border-2 border-dashed border-gray-300 rounded-lg p-10 text-center hover:border-gray-400 transition-colors cursor-pointer">
            <ArrowUpTrayIcon className="h-12 w-12 text-gray-400 mx-auto" />
            <p className="mt-2 text-sm text-gray-600">
              Click to upload or drag and drop SVG, PNG, JPG or GIF (MAX.
              800x400px)
            </p>
          </div>
        </div>

        {/* Action Buttons */}
        <div className="flex justify-end space-x-4">
          <button
            type="button"
            className="rounded-md border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-700 shadow-sm hover:bg-gray-50"
          >
            Draft
          </button>
          <button
            type="submit"
            className="rounded-md border border-transparent bg-blue-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-blue-700"
          >
            Publish Product
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddProductForm;

export const color = [
  "white",
  "black",
  "red",
  "blue",
  "Maroon",
  "Green",
  "Yellow",
];

export const size = ["S", "M", "L", "XL", "XXL"];

export const filters = [
  {
    id: "color",
    name: "Color",
    options: [
      { value: "white", label: "White" },
      { value: "black", label: "Black" },
      { value: "red", label: "Red" },
      { value: "blue", label: "Blue" },
      { value: "Maroon", label: "Maroon" },
      { value: "Green", label: "Green" },
      { value: "Yellow", label: "Yellow" },
    ]
  },
  {
    id: "size",
    name: "Size",
    options: [
      { value: "S", label: "S" },
      { value: "M", label: "M" },
      { value: "L", label: "L" },
      { value: "XL", label: "XL" },
      { value: "XXL", label: "XXL" },
    ]
  }];


export const singleFilters = [
  {
    id: "price",
    name: "Price",
    options: [
      { value: "159-399", label: "₹159 - ₹399" },
      { value: "399-999", label: "₹399 - ₹999" },
      { value: "999-1999", label: "₹999 - ₹1999" },
      { value: "1999-3999", label: "₹1999 - ₹3999" },
      { value: "3999-4999", label: "₹3999 - ₹4999" },
    ],
  },

  {
    id: "discount",
    name: "Discount Range",
    options: [
      { value: "10", label: "10% and Above" },
      { value: "20", label: "20% and Above" },
      { value: "30", label: "30% and Above" },
      { value: "40", label: "40% and Above" },
      { value: "50", label: "50% and Above" },
      { value: "60", label: "60% and Above" },
      { value: "70", label: "70% and Above" },
      { value: "80", label: "80% and Above" },
    ],
  },

  {
    id: "stock",
    name: "Availability",
    options: [
      { value: "in_stock", label: "In Stock" },
      { value: "out_of_stock", label: "Out of Stock" },
    ],
  },
];
export const sortOptions = [
  {
    name: "Price:low to High",
    query: "price_low",
    current:false
  },
   {
    name: "Price:High to Low",
    query: "price_high",
    current:false
  },
]
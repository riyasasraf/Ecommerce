import categoryInstance from "./categoryInstance";

export async function getCategories() {
  // pass AbortController.signal optionally
  const res = await categoryInstance.get("/api/v1/category")

  return res.data; // array of CategoryResponse
}

export async function getSubcategories() {}

export default { getCategories, getSubcategories };

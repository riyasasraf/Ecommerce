import {
  Home
} from "@mui/icons-material";
// No need to import Profile, AppliedJobs, ResumeBuilder here directly anymore,
// as they will be rendered by the <Outlet /> based on the route.
import { Link, Outlet, useLocation } from "react-router-dom"; // Import Link, Outlet, and useLocation

const DashBoard = () => {
  const location = useLocation(); // Hook to get the current URL location

  // Function to determine if a link is active for styling
  const isActiveLink = (path) => location.pathname === path;

  return (
    <div className="flex flex-1 bg-gray-100 font-inter">
      {/* Sidebar */}
      <aside className="w-64 h-screen bg-white shadow-lg flex flex-col rounded-lg m-4">
        <div className="p-4 flex items-center border-b border-gray-200">
          {/* Placeholder for logo/brand */}
          <svg
            className="w-8 h-8 text-indigo-600"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M13 10V3L4 14h7v7l9-11h-7z"
            ></path>
          </svg>
          <span className="ml-2 text-xl font-bold text-gray-800">Your App</span>
        </div>

        <nav className="flex-1 p-4 space-y-2">
          {/* Use Link components for navigation */}
          <Link
            to="/dashboard/products" // Updated path
            className={`flex items-center p-2 rounded-lg transition-colors duration-200 ${
              isActiveLink("/dashboard/products")
                ? "text-indigo-600 bg-indigo-50 hover:bg-indigo-100"
                : "text-gray-700 hover:bg-gray-100"
            }`}
          >
            <Home className="h-5 w-5 mr-3" />
            Products
          </Link>
          <Link
            to="/dashboard/add-product" // Updated path
            className={`flex items-center p-2 rounded-lg transition-colors duration-200 ${
              isActiveLink("/dashboard/add-product")
                ? "text-indigo-600 bg-indigo-50 hover:bg-indigo-100"
                : "text-gray-700 hover:bg-gray-100"
            }`}
          >
            <Home className="h-5 w-5 mr-3" />
            Add Products
          </Link>
        </nav>
      </aside>

      <main className="flex-1 p-4 overflow-auto">
        <Outlet />
      </main>
    </div>
  );
};

export default DashBoard;

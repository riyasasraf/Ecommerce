"use client";

import { useState, useEffect } from "react";
import {
  Dialog,
  DialogBackdrop,
  DialogPanel,
  Disclosure,
  DisclosureButton,
  DisclosurePanel,
  Menu,
  MenuButton,
  MenuItem,
  MenuItems,
} from "@headlessui/react";
import {
  XMarkIcon,
  ChevronDownIcon,
  FunnelIcon,
  MinusIcon,
  PlusIcon,
  Squares2X2Icon,
} from "@heroicons/react/20/solid";
import { mens_kurta } from "../data/Mens_kurthas";
import Productcard from "./Productcard";
import { filters, singleFilters } from "./FilterData";
import { useLocation, useNavigate } from "react-router-dom";

const sortOptions = [
  { name: "Price: Low to High", href: "#", current: false },
  { name: "Price: High to Low", href: "#", current: false },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function Product() {
  const [mobileFiltersOpen, setMobileFiltersOpen] = useState(false);
  const location = useLocation();
  const navigate = useNavigate();

  const searchParams = new URLSearchParams(location.search);

  const updateFilterQuery = (sectionId, value, checked) => {
    const current = new URLSearchParams(location.search);
    const values = current.getAll(sectionId);

    if (checked) {
      current.append(sectionId, value);
    } else {
      const newValues = values.filter((v) => v !== value);
      current.delete(sectionId);
      newValues.forEach((v) => current.append(sectionId, v));
    }

    navigate(`${location.pathname}?${current.toString()}`, { replace: true });
  };

  const isChecked = (sectionId, value) => {
    const current = searchParams.getAll(sectionId);
    return current.includes(value);
  };

  return (
    <div className="bg-white">
      {/* Mobile Filter Dialog */}
      <Dialog
        open={mobileFiltersOpen}
        onClose={setMobileFiltersOpen}
        className="relative z-40 lg:hidden"
      >
        <DialogBackdrop className="fixed inset-0 bg-black/25" />
        <div className="fixed inset-0 z-40 flex">
          <DialogPanel className="ml-auto flex w-full max-w-xs flex-col overflow-y-auto bg-white pt-4 pb-6 shadow-xl">
            <div className="flex items-center justify-between px-4">
              <h2 className="text-lg font-medium text-gray-900">Filters</h2>
              <button
                type="button"
                onClick={() => setMobileFiltersOpen(false)}
                className="p-2 text-gray-400 hover:bg-gray-100 rounded-md"
              >
                <XMarkIcon className="w-6 h-6" />
              </button>
            </div>

            {/* Mobile Filters */}
            <form className="mt-4 border-t border-gray-200">
              {[...filters, ...singleFilters].map((section) => (
                <Disclosure key={section.id} as="div" className="px-4 py-6">
                  <h3 className="-mx-2 -my-3 flow-root">
                    <DisclosureButton className="group flex w-full items-center justify-between bg-white px-2 py-3 text-gray-400 hover:text-gray-500">
                      <span className="font-medium text-gray-900">
                        {section.name}
                      </span>
                      <span className="ml-6 flex items-center">
                        <PlusIcon className="h-5 w-5 group-data-open:hidden" />
                        <MinusIcon className="h-5 w-5 group-not-data-open:hidden" />
                      </span>
                    </DisclosureButton>
                  </h3>
                  <DisclosurePanel className="pt-6">
                    <div className="space-y-6">
                      {section.options.map((option, idx) => (
                        <div key={option.value} className="flex gap-3">
                          <input
                            id={`filter-mobile-${section.id}-${idx}`}
                            name={`${section.id}[]`}
                            type="checkbox"
                            defaultChecked={isChecked(section.id, option.value)}
                            onChange={(e) =>
                              updateFilterQuery(
                                section.id,
                                option.value,
                                e.target.checked
                              )
                            }
                            className="rounded border-gray-300 text-indigo-600"
                          />
                          <label
                            htmlFor={`filter-mobile-${section.id}-${idx}`}
                            className="text-gray-600"
                          >
                            {option.label}
                          </label>
                        </div>
                      ))}
                    </div>
                  </DisclosurePanel>
                </Disclosure>
              ))}
            </form>
          </DialogPanel>
        </div>
      </Dialog>

      <main className="px-4 sm:px-6 lg:px-20">
        <div className="flex items-baseline justify-between border-b border-gray-200 pt-24 pb-6">
          <h1 className="text-4xl font-bold tracking-tight text-gray-900">
            New Arrivals
          </h1>

          <div className="flex items-center">
            <Menu as="div" className="relative inline-block text-left">
              <MenuButton className="group inline-flex text-sm font-medium text-gray-700 hover:text-gray-900">
                Sort
                <ChevronDownIcon className="ml-1 h-5 w-5" />
              </MenuButton>
              <MenuItems className="absolute right-0 z-10 mt-2 w-40 origin-top-right rounded-md bg-white shadow-lg ring-1 ring-black/5 focus:outline-none">
                {sortOptions.map((option) => (
                  <MenuItem key={option.name}>
                    <a
                      href={option.href}
                      className={classNames(
                        option.current
                          ? "font-medium text-gray-900"
                          : "text-gray-500",
                        "block px-4 py-2 text-sm hover:bg-gray-100"
                      )}
                    >
                      {option.name}
                    </a>
                  </MenuItem>
                ))}
              </MenuItems>
            </Menu>

            <button
              type="button"
              onClick={() => setMobileFiltersOpen(true)}
              className="ml-4 p-2 text-gray-400 hover:text-gray-500 lg:hidden"
            >
              <FunnelIcon className="h-5 w-5" />
            </button>
          </div>
        </div>

        <section className="pt-6 pb-24">
          <div className="grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-5">
            {/* Desktop Filters */}
            <form className="hidden lg:block">
              {[...filters, ...singleFilters].map((section) => (
                <Disclosure
                  key={section.id}
                  as="div"
                  className="border-b border-gray-200 py-6"
                >
                  <h3 className="-my-3 flow-root">
                    <DisclosureButton className="group flex w-full justify-between text-sm text-gray-400 hover:text-gray-500">
                      <span className="font-medium text-gray-900">
                        {section.name}
                      </span>
                      <span className="ml-6 flex items-center">
                        <PlusIcon className="h-5 w-5 group-data-open:hidden" />
                        <MinusIcon className="h-5 w-5 group-not-data-open:hidden" />
                      </span>
                    </DisclosureButton>
                  </h3>
                  <DisclosurePanel className="pt-6">
                    <div className="space-y-4">
                      {section.options.map((option, idx) => (
                        <div key={option.value} className="flex gap-3">
                          <input
                            id={`filter-${section.id}-${idx}`}
                            name={`${section.id}[]`}
                            type="checkbox"
                            checked={isChecked(section.id, option.value)}
                            onChange={(e) =>
                              updateFilterQuery(
                                section.id,
                                option.value,
                                e.target.checked
                              )
                            }
                            className="rounded border-gray-300 text-indigo-600"
                          />
                          <label
                            htmlFor={`filter-${section.id}-${idx}`}
                            className="text-sm text-gray-600"
                          >
                            {option.label}
                          </label>
                        </div>
                      ))}
                    </div>
                  </DisclosurePanel>
                </Disclosure>
              ))}
            </form>

            {/* Product grid */}
            <div className="lg:col-span-4 w-full">
              <div className="flex flex-wrap justify-center gap-4 py-5">
                {mens_kurta.map((item, idx) => (
                  <Productcard key={idx} Product={item} />
                ))}
              </div>
            </div>
          </div>
        </section>
      </main>
    </div>
  );
}

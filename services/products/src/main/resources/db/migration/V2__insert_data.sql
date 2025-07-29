
INSERT INTO category (id, name, description) VALUES (1, 'Electronics', 'Devices and gadgets');
INSERT INTO category (id, name, description) VALUES (2, 'Clothing', 'Apparel and garments');
INSERT INTO category (id, name, description) VALUES (3, 'Books', 'Printed and digital books');
INSERT INTO category (id, name, description) VALUES (4, 'Groceries', 'Everyday food and supplies');
INSERT INTO category (id, name, description) VALUES (5, 'Fitness', 'Health and workout equipment');


-- Electronics
INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (1, 'Smartphone', 'Android-based 5G phone', 25, 699.99, 1);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (2, 'Laptop', '14-inch lightweight ultrabook', 10, 999.00, 1);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (3, 'Bluetooth Speaker', 'Portable wireless speaker', 40, 49.99, 1);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (4, 'Smartwatch', 'Fitness tracking wearable', 30, 199.99, 1);

-- Clothing
INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (5, 'T-Shirt', 'Cotton unisex t-shirt', 100, 19.99, 2);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (6, 'Jeans', 'Slim fit denim jeans', 60, 49.99, 2);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (7, 'Jacket', 'Waterproof winter jacket', 15, 89.99, 2);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (8, 'Socks', 'Pack of 3 ankle socks', 200, 9.99, 2);

-- Books
INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (9, 'Java Programming', 'Beginner to advanced Java', 50, 39.99, 3);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (10, 'Data Structures', 'Computer science fundamentals', 45, 29.99, 3);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (11, 'Cookbook', 'Easy recipes for home', 35, 24.99, 3);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (12, 'Startup Guide', 'How to build a business', 20, 34.99, 3);

-- Groceries
INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (13, 'Rice - 5kg', 'Premium basmati rice', 75, 12.50, 4);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (14, 'Olive Oil - 1L', 'Extra virgin olive oil', 50, 15.99, 4);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (15, 'Milk - 1L', 'Fresh cow milk', 100, 1.29, 4);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (16, 'Bread', 'Whole wheat loaf', 80, 2.50, 4);

-- Fitness
INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (17, 'Yoga Mat', 'Non-slip exercise mat', 30, 25.00, 5);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (18, 'Dumbbell Set', '10kg adjustable dumbbells', 20, 55.00, 5);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (19, 'Protein Powder', '1kg chocolate whey protein', 40, 45.00, 5);

INSERT INTO products (id, name, description, available_quantity, price, category_id)
VALUES (20, 'Skipping Rope', 'Adjustable speed rope', 70, 10.00, 5);

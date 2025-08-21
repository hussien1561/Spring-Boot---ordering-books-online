-- =====================
-- ITEMS
-- =====================
-- Keep IDs here because items are usually reference data

INSERT INTO item (id, title, price, category, length, release_date, stock, min_quantity_threshold)
VALUES
  (1, 'Clean Code', 100, 'Programming', '464 pages', '2025-10-10', 50, 5),
  (2, 'Effective Java', 200, 'Programming', '416 pages', NULL, 50, 5),
  (3, 'Spring in Action', 300, 'Programming', '520 pages', '2025-10-10', 50, 5),
  (4, 'Design Patterns: Elements of Reusable Object-Oriented Software', 100, 'Programming', '395 pages', NULL, 50, 5),
  (5, 'Refactoring: Improving the Design of Existing Code', 200, 'Programming', '448 pages', '2025-10-10', 50, 5),

  (6, 'Head First Design Patterns', 300, 'Programming', '694 pages', NULL, 10, 5),
  (7, 'Introduction to Algorithms', 100, 'Programming', '1312 pages', '2025-10-10', 20 , 5),
  (8, 'Java Concurrency in Practice', 200, 'Programming', '384 pages', NULL, 20, 5),
  (9, 'Atomic Habits', 300, 'Self-Help', '320 pages', '2025-10-10',10, 5),
  (10, 'The Power of Habit', 100, 'Self-Help', '371 pages', NULL, 50, 5),
  (11, 'Deep Work', 200, 'Self-Help', '304 pages', NULL,50, 5),
  (12, 'The 7 Habits of Highly Effective People', 300, 'Self-Help', '381 pages', NULL, 50, 5),

  (13, 'A Brief History of Time', 100, 'Science', '212 pages', '2025-10-10', 50, 5),
  (14, 'Cosmos', 200, 'Science', '396 pages', NULL, 50, 5),
  (15, 'sapiens', 100, 'Science', '212 pages', '2025-10-10', 50, 5),
  (16, 'integral medicine', 200, 'Science', '396 pages', NULL, 50, 5);


-- =====================  
-- CUSTOMERS
-- =====================
-- Keep IDs if customer uses assigned IDs
INSERT INTO customer (id, name, email, phone_number)
VALUES
  (1, 'Alice Johnson', 'alice@example.com', '123456789'),
  (2, 'Bob Smith', 'bob@example.com', '987654321'),
  (3, 'Ali Baba', 'aob@example.com',  '147654321');


-- =====================
--  Sample discount rules
-- =====================

INSERT INTO discount_rule (min_quantity, percent)
VALUES
  (3, 5),   -- Buy 3 or more, get 5% off
  (5, 10),  -- Buy 5 or more, get 10% off
  (10, 15), -- Buy 10 or more, get 15% off
  (20, 20); -- Buy 20 or more, get 20% off

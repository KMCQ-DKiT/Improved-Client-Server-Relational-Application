DROP DATABASE IF EXISTS `product_database`;
CREATE DATABASE `product_database`;
USE `product_database`;
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
                          `SORT_CODE` int(11) NOT NULL AUTO_INCREMENT,
                          `PRODUCT_NAME` varchar(50) NOT NULL,
                          `PRODUCT_DESC` varchar(50) NOT NULL,
                          `PRODUCT_PRICE` DECIMAL(20) NOT NULL,
                          `PRODUCT_TYPE` varchar(50) NOT NULL,
                          PRIMARY KEY  (`SORT_CODE`)
);

INSERT INTO products VALUES (1196549, "Fleetwood 5L Sheen Warm Grey", "Easy Application, Quick Drying, Low Odour, Water Based " , 36.00, "Paint"),
                            (1096007, "Fleetwood 2.5 Litre Sheen Smithsonian", "Walls and ceilings, Stains wipe clean, Excellent coverage, Easy to apply", 22.00, "Paint"),
                            (375460, "Dulux Vinyl Soft Sheen Tir na nOg 5L", "Tough washable finish, Fashionable mid-sheen finish, Coverage of up to 16m2", 58.99, "Paint"),
                            (324900, "Dulux Easycare Kitchens Iced White 2.5L", "Stain Resistant, Withstands Scrubbing, Washable", 51.99, "Paint"),
                            (1145539, "Black+Decker 1600W Corded 38CM Electric Lawnmower", "Bike Handle design for improved ergonomics and even weight distribution", 199.99, "GardenTools"),
                            (1156976, "Black+Decker 1000W Corded 32CM Lawnmower", "1000W Mower with 32cm cutting deck, perfect for keeping your garden lawn tidy", 99.99, "GardenTools"),
                            (1201772, "Pro Lawn 46cm Self Propelled B&S Petrol Lawnmower", "Powerful Briggs & Stratton engine delivers effortless mowing", 379.99, "GardenTools"),
                            (1156605, "Black+Decker 500W Corded Hammer Drill", "Hammer action suitable for drilling into masonry", 42.99, "PowerTools"),
                            (1185298, "Stanley Fatmax V20 18V Brushless Hammer Drill", "No memory effect and minimal self-discharge", 129.99, "PowerTools"),
                            (1119995, "Black+Decker 3.6V Lithium Screwdriver", "Lithium-ion battery provides adequate power", 27.99, "PowerTools");

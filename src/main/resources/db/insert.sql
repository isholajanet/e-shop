set foreign_key_checks=0;

truncate table Product;
truncate table feedback;


insert into product(`id`, `name`, `price`, `details`, `currency`)
values(110, 'luxury chair', 4500, 'my first spring project', 'SRC'),
      (111, 'luxury sofa', 4000, 'my first spring project', 'FRC'),
      (112, 'luxury bench', 6500, 'my first spring project', 'USD'),
      (113, 'luxury table', 8500, 'my first spring project', 'NGN');

set foreign_key_checks=1;
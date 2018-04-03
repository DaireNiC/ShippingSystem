insert into shipping_company (scid, balance, home_port, name) values (900, 20000000, "Cork Harbour", "P&O");
insert into shipping_company (scid, balance, home_port, name) values (901, 97000000, "Portsmouth", "Cunard Line");
insert into shipping_company (scid, balance, home_port, name) values (902, 97000000, "Rotterdam", "Maersk");
insert into shipping_company (scid, balance, home_port, name) values (903, 107000000, "Miami", "Royal Caribbean");

insert into ship (sid, cost, name, passengers, metres, scid) values (100, 5000000, "Titanic", 1253, 269, 901);
insert into ship (sid, cost, name, passengers, metres, scid) values (101, 4000000, "Olympic", 952, 269, 901);
insert into ship (sid, cost, name, passengers, metres, scid) values (102, 9500000, "Star of the Sea", 2952, 404, 900);
insert into ship (sid, cost, name, passengers, metres, scid) values (103, 6333000, "Oceans 11", 4552, 702, 903);
insert into ship (sid, cost, name, passengers, metres, scid) values (104, 6333000, "Mary Celeste", 0, 202, NULL);

insert into order_info (oid, scid, sid, date) values (500, 901, 100, "1912-01-01");
insert into order_info (oid, scid, sid, date) values (501, 901, 101, "1908-07-12");
insert into order_info (oid, scid, sid, date) values (502, 900, 102, "2011-12-01");
insert into order_info (oid, scid, sid, date) values (503, 903, 103, "2016-03-07");

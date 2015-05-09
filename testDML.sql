
/*users*/
insert into Users values ("1","simon","simon","simon@simon.com","2015-05-02 08:00:00", "E");
insert into Users values ("2","aaron","aaron","aaron@aaron.com","2015-05-02 08:00:00", "E");
insert into Users values ("3","koby","koby","koby@koby.com","2015-05-02 08:00:00", "E");
insert into Users values ("4","joe","joe","joe@joe.com","2015-05-02 08:00:00", null);

/*views*/


/*region*/
insert into SpecimenRegion values ("forest","It's a  place with trees.");
insert into SpecimenRegion values ("desert","Sand sand sand.\n you know a bunch of sand.");

/*plant*/
insert into Plant values("1","Dolly Horn", "Magnolia", "x", "It's a magnolia.");
insert into Plant values("2","Apollo", "Magnolia", "x", "It's another magnolia.");
insert into Plant values("3","Butterflies", "Magnolia", "x", "It's more magnolia.");
insert into Plant values("4","Crimson Queen", "Acer Palmatum", "Dissectum", "It's more magnolia.");

/*specimen*/
insert into Specimen values("1","1","Planted for shade.", 0,0,"2015-05-02 08:00:00", "forest");
insert into Specimen values("4","2","Planted for color.", 0,0,"2015-05-02 08:00:00", "forest");
insert into Specimen values("4","3","From people down the road.", 0,0,"2015-05-02 08:00:00", "forest");
insert into Specimen values("3","4","Planted for shade.", 0,0,"2015-05-02 08:00:00", "forest");

/*plant image*/
insert into PlantImage values ("1", "1","http://en.wikipedia.org/wiki/Magnolia#/media/File:Magn%C3%B2lia_a_Verbania.JPG", "This is a magnolia flower");
insert into PlantImage values ("1", "2", "http://en.wikipedia.org/wiki/Magnolia#/media/File:Magnolia_Fruit_(South_America).JPG", "This is a magnolia seed cone");

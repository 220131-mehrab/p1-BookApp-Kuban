CREATE TABLE "books" (
    "BookId" INT PRIMARY KEY NOT NULL,
    "Name" VARCHAR
);

CREATE TABLE "library" (
    "LibraryId" INT NOT NULL,
    "Title" VARCHAR NOT NULL,
    "BookId" INT NOT NULL,
    CONSTRAINT "PK_Library" PRIMARY KEY ("LibraryId"),
    CONSTRAINT "FK_LibraryBookId" FOREIGN KEY ("BookId") REFERENCES "books" ("BookId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX "IFK_LibraryBookId" ON "library" ("BookId");

INSERT INTO "books" VALUES (1, 'Pride and Prejudice');
INSERT INTO "books" VALUES (2, '1984');
INSERT INTO "books" VALUES (3, 'Crime and Punishment');
INSERT INTO "books" VALUES (4, 'Hamlet');
INSERT INTO "books" VALUES (5, 'One Hundred Years of Solitude');
INSERT INTO "books" VALUES (6, 'Anna Karenina');
INSERT INTO "books" VALUES (7, 'The Odyssey');
INSERT INTO "books" VALUES (8, 'The Stranger');
INSERT INTO "books" VALUES (9, 'The Brothers Karamazov');
INSERT INTO "books" VALUES (10, 'The Old Man and the Sea');
INSERT INTO "books" VALUES (11, 'Lolita');
INSERT INTO "books" VALUES (12, 'Great Expectations');
INSERT INTO "books" VALUES (13, 'War and Peace');
INSERT INTO "books" VALUES (14, 'Don Quixote');
INSERT INTO "books" VALUES (15, 'The Iliad');
INSERT INTO "books" VALUES (16, 'Madame Bovary');
INSERT INTO "books" VALUES (17, 'The Trial');
INSERT INTO "books" VALUES (18, 'Moby-Dick or, the Whale');
INSERT INTO "books" VALUES (19, 'King Lear');
INSERT INTO "books" VALUES (20, 'The Divine Comedy');
INSERT INTO "books" VALUES (21, 'Love in the Time of Cholera');
INSERT INTO "books" VALUES (22, 'The Complete Fairy Tales');
INSERT INTO "books" VALUES (23, 'Othello');
INSERT INTO "books" VALUES (24, 'The Arabian Nights');
INSERT INTO "books" VALUES (25, 'Mrs. Dalloway');
INSERT INTO "books" VALUES (26, 'The Canterbury Tales');
INSERT INTO "books" VALUES (27, 'Oedipus Rex');
INSERT INTO "books" VALUES (28, 'Gullivers Travels: Travels into Several Remote Nations of the World.');
INSERT INTO "books" VALUES (29, 'Ulysses');
INSERT INTO "books" VALUES (30, 'Pippi Longstocking');


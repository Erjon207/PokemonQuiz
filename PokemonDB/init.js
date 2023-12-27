db = db.getSiblingDB('mongodb');

db.createCollection('pokemons');

db.pokemons.insertMany([
    {
        "name": "Pikachu",
        "health": 80,
        "strenght": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Karpador",
        "health": 30,
        "strenght": 10,
        "energy": 1,
        "stage": 1
    }
]);
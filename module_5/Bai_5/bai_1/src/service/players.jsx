let players = [
    { id: 1, code: "CT01", name: "Messi", dob: "1987-06-24", price: 500000, position: "FW" },
    { id: 2, code: "CT02", name: "Ronaldo", dob: "1985-02-05", price: 450000, position: "FW" },
];

export const getAllPlayers = () => {
    return players;
};

export const addNew = (player) => {
    players.push(player);
};

export const deletePlayer = (id) => {
    players = players.filter(p => p.id != id);
};

export const getById = (id) => {
    return players.find(p => p.id == id);
};

export const updatePlayer = (id, newData) => {
    players = players.map(p =>
        p.id == id ? { ...p, ...newData } : p
    );
};

export const searchPlayer = (keyword) => {
    return players.filter(p =>
        p.name.toLowerCase().includes(keyword.toLowerCase()) ||
        p.code.toLowerCase().includes(keyword.toLowerCase())
    );
};

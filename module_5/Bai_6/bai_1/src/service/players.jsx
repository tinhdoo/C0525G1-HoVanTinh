const API = "http://localhost:3000/players";

export const getAllPlayers = async () => {
    const res = await fetch(`${API}?_expand=position&_sort=id&_order=desc`);
    return await res.json();
};

export const addNew = async (player) => {
    await fetch(API, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(player)
    });
};

export const deletePlayer = async (id) => {
    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });
};

export const getById = async (id) => {
    const res = await fetch(`${API}/${id}`);
    return await res.json();
};

export const updatePlayer = async (id, newData) => {
    await fetch(`${API}/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(newData)
    });
};

export const searchPlayer = async (keyword) => {
    const res = await fetch(`${API}?q=${keyword}&_expand=position`);
    return await res.json();
};
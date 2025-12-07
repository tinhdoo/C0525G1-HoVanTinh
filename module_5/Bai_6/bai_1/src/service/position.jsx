const API = "http://localhost:3000/positions";

export const getAllPositions = async () => {
    const res = await fetch(API);
    return await res.json();
};

export const getPositionById = async (id) => {
    const res = await fetch(`${API}/${id}`);
    return await res.json();
};

const players = [
    {
        id: 1,
        code: "CG01",
        name: "Tịnh",
        dob: "2002",
        price: 2000000,
        position: "TĐ"
    }, {
        id: 2,
        code: "CG02",
        name: "Thành",
        dob: "2002",
        price: 200000,
        position: "NG"
    }, {
        id: 3,
        code: "CG03",
        name: "Tâm",
        dob: "2004",
        price: 20000,
        position: "OC"
    }
]
export function getAllPlayers() {
    return [...players];
}
export function deletePlayer(id) {
    for (let i = 0; i < players.length; i++) {
        if (players[i].id === id) {
            players.splice(i, 1);
            break;
        }
    }
}
export function addNew(player) {
    players.push(player);
}
export function searchPlayer(keyword) {
    if (!keyword) return [...players];
    const lowerKey = keyword.toLowerCase();
    return players.filter(player =>
        player.name.toLowerCase().includes(lowerKey)
    );
}


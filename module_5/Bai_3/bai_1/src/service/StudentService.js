
const studentList = [
    {
        id: 1,
        name: "chánh"
    },
    {
        id: 2,
        name: "tiến"
    },
    {
        id: 3,
        name: "Hải heo"
    }
]
// viết phương thức để callAPI
export function getAll(){
    return [...studentList];
}
export function deleteById(id){
    for (let i = 0; i <studentList.length ; i++) {
        if (studentList[i].id==id){
            studentList.splice(i,1);
            break;
        }
    }
}
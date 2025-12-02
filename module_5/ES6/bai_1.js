//Bài 1
const isPrime = (n) => {
    if (n < 2) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
    }
    return true;
};

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const primeNumbers = numbers.filter(isPrime);

console.log(primeNumbers);


//Bài 2
const person = {
    firstName: 'John',
    lastName: 'Doe',
    age: 30,
    gender: 'male',
    occupation: 'developer',
    nationality: 'American',
    city: 'New York',
    hobbies: ['reading', 'traveling', 'photography'],
    languages: ['English', 'Spanish'],
    education: {
        degree: 'Bachelor',
        major: 'Computer Science',
        university: 'Harvard University'
    }
};

const {
    firstName,
    gender,
    education: {degree},
    languages: [english]
} = person;

const student = {
    firstName,
    gender,
    degree,
    english
};

console.log(student);

//Bài 3
function getInfo(obj) {
    const {
        firstName = "Quân",
        degree = "NA"
    } = obj;

    console.log(`firstName: ${firstName}`);
    console.log(`degree: ${degree}`);
}

const sv1 = {
    firstName: 'John',
    gender: 'male',
    degree: 'Bachelor',
    english: 'English'
};
getInfo(sv1);

const sv2 = {
    name: 'John',
    gender: 'male',
    degree: 'Bachelor',
    english: 'English'
};
getInfo(sv2);

//Bài 4
let courses = [
    {id: 1, title: "ReactJS Tutorial", rating: 4.2},
    {id: 2, title: "Angular Tutorial", rating: 2.5},
    {id: 3, title: "VueJS Tutorial", rating: 3.8},
    {id: 4, title: "Java Tutorial", rating: 4},
    {id: 5, title: "JavaScript Tutorial", rating: 3.5},
];

const result = courses
    .filter(({rating}) => rating >= 4);

result.forEach(({id, title, rating}) => {
    console.log(`ID: ${id} - ${title} - Rating: ${rating}`);
});

//Bài 5
const result = courses
    .filter(({rating}) => rating < 4)
    .map(({id, title, rating}) => `${id} - ${title} - ${rating}`);

//Bài 6
let addedCourses = [
    {
        id: 6,
        title: "PHP Tutorial",
        rating: 3,
    },
    {
        id: 7,
        title: "C# Tutorial",
        rating: 2,
    },
    {
        id: 8,
        title: "Docker Tutorial",
        rating: 3.8,
    }
];
const mergeCourses = (courses, addedCourses) => [...courses, ...addedCourses];

const allCourses = mergeCourses(courses, addedCourses);
console.log(allCourses);

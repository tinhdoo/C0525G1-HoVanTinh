import React, { Component } from "react";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [],
            item: ""
        };
    }

    handleChange = (event) => {
        this.setState({ item: event.target.value });
    };

    handleAddItem = () => {
        const { item, list } = this.state;

        if (item.trim() !== "") {
            this.setState({
                list: [...list, item],
                item: "" // reset input
            });
        }
    };

    render() {
        return (
            <div style={{ margin: "30px" }}>
                <h1>Todo List</h1>

                <input
                    type="text"
                    value={this.state.item}
                    onChange={this.handleChange}
                    placeholder="Nhập công việc..."
                    style={{ padding: "6px", width: "250px" }}
                />

                <button
                    onClick={this.handleAddItem}
                    style={{ marginLeft: "10px", padding: "6px 12px" }}
                >
                    Add
                </button>

                <ul style={{ marginTop: "20px" }}>
                    {this.state.list.map((todo, index) => (
                        <li key={index}>{todo}</li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default App;

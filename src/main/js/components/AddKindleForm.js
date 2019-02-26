import React from "react";
import { addKindle } from "../actions/userActions"

export default class AddKindleForm extends React.Component {

  constructor() {
    super();
    this.state = {

      serial: "",
      model: "",
      inches: ""
    
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
      this.addKindle();
      console.log("item inserted")
    }
  }

  addKindle() {
    addKindle(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <input type="integer" class="form-control"
            name="serial"
            placeholder="Add a new user Serial..."
            value={this.state.serial}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            name="model"
            placeholder="Add a new user model..."
            value={this.state.model}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            placeholder="Add tamaño of inches..."
            name="inches"
            value={this.state.inches}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addKindle.bind(this)}>Insert User</button>
        </div>
      </div>
    );
  }
}
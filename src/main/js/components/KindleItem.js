import React from "react";
import Delete from "./Delete"
export default class KindleItem extends React.Component {

	constructor(props) {
    super(props)
    this.state = { kindle: props.kindle } 
	}

  render() {

    const { kindle } = this.props;
  
    return (
      <div class="well col-md-4 col-md-offset-4" key={kindle.serial}>
        nombre: {kindle.serial} apellido: {kindle.model} dni: {kindle.inches}<br/>
        <Delete id={kindle.serial}/>
      </div> 
    );
  }
}

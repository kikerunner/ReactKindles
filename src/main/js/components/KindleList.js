import React from "react";
import KindleItem from "./KindleItem"
import UserCount from "./UserCount"

export default class KindleList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { kindles: [] }
	}

  render() {
		if (this.state.kindles.length == 0) {	
			fetch('/api/v1/kindle/list/')
			.then((response) => {
				return response.json();
			})			
			.then((kindle) => {
        		this.setState({ kindles: kindle })
      		})
			
		}

		if (this.state.kindles.length > 0) {
		
			var kindleItems = [];
			this.state.kindles.forEach(
				(kindle) => {
					kindleItems.push(<KindleItem kindle={kindle} />)
				}
			)
		
		return (
				<div>
					{kindleItems}
					<UserCount  count={kindleItems.length}/>
				</div>
			)
			
		
		} else {
			return <p className="text-center">Loading users...</p>
		}


    
  }
}
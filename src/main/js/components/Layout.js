import React from "react"
import { addUser } from "../actions/userActions"
import AddKindleForm from "./AddKindleForm"
import KindleList from "./KindleList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
        <AddKindleForm />
        <KindleList />
      </div>
    )
  }
}

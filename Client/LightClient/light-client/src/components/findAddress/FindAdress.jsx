import React, { Component, Fragment } from "react";
import Maps from "./Map";
import SearchBox from "./SearchBox";
import {  Button, Modal } from 'react-bootstrap'
class FindAdress extends Component {
  constructor() {
    super();
    this.state = {
      selectPosition: null,
      show: false,
      userLat: "",
      userLng: "",
      findOrFound: "Search Location"
    }
  }
  componentDidMount(){
    this.setState({
      findOrFound: this.props.chooseTxt
    })
  }
  setSelectPosition = (pos) => {
    this.setState({ selectPosition: pos })
  }
  setShow = (show) => {
    this.setState({ show: show })
  }
  setFindOrFound=(f)=>{
    if(f==true){ //found
      this.setState({findOrFound:this.props.changeTxt})
    }
    else{
      this.setState({findOrFound:this.props.chooseTxt})
    }
  }

  render() {
    return (
      <Fragment>
        <Button onClick={() => this.setShow(true)}>{this.state.findOrFound}</Button>
        <Modal size="xl"
          show={this.state.show} onHide={() => this.setShow(false)}>
          <Modal.Header closeButton>
            <h6>Find your Location</h6>
          </Modal.Header>
          <Modal.Body>
            <div
              style={{
                display: "flex",
                flexDirection: "colonne",
                width: "100%",
                height: "50vh",
              }}
            >
              <div style={{ width: "50vw" }}>
                <SearchBox setShow={this.setShow} selectPosition={this.state.selectPosition} setSelectPosition={this.setSelectPosition} location={this.props.location} setLocation={this.props.setLocation} setFindOrFound={this.setFindOrFound}/>
              </div>
              <div style={{ width: "50vw", height: "100%" }}>
                <Maps selectPosition={this.state.selectPosition} setSelectPosition={this.setSelectPosition} location={this.props.location} setLocation={this.props.setLocation} setFindOrFound={this.setFindOrFound} />
              </div>
            </div>
          </Modal.Body>
          <Modal.Footer>

          </Modal.Footer>
        </Modal>
      </Fragment>
    );
  }

}

export default FindAdress;
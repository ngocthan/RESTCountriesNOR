import React, { Component, Fragment } from 'react';

class Result extends Component {
    render(){
        var showResult = false;
        if(Object.keys(this.props.norData).length > 0){
            showResult = true;
        }

        return(
            <Fragment>
                {showResult &&
                   <div>
                        <span>flag: <img src={this.props.norData.flag} width="50"/></span><br/>
                        <span>Name: {this.props.norData.name} </span><br/>
                        <span>TopLevelDomain: {this.props.norData.topLevelDomain} </span><br/>
                        <span>Alpha2Code: {this.props.norData.alpha2Code} </span><br/>
                        <span>Capital: {this.props.norData.capital} </span><br/>
                        <span>Region: {this.props.norData.region} </span><br/>
                        <span>population: {this.props.norData.population} </span><br/>
                        <span>Demonym: {this.props.norData.demonym} </span><br/>
                        <span>Area: {this.props.norData.area} </span><br/>
                        <span>Currency: {this.props.norData.currencies[0].code} </span><br/>
                        <span>Language: {this.props.norData.languages[0].name} </span>
                   </div>
                }
            </Fragment>
        );
    }
}

export default Result;
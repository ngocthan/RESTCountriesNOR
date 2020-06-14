import React, { Component, Fragment } from 'react';
import { Row, Col } from 'reactstrap';
import axios from 'axios';
import LoadingSpinner from './LoadingSpinner';
import NorData from './NorData';
import Header from './Header';

class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            fetchInProgress: false,
            norData: {}
        };
    }

    componentWillMount() {
        this.getNorData();
    }

    getNorData(){
        this.setState({fetchInProgress: true});
        var url = '/restcountriesnor/api/getNorData';
        axios.get(url)
            .then(response => {
                //console.log(response.data);
                this.setState({
                    fetchInProgress: false,
                    norData: response.data
                });
            })
            .catch(error => {
                console.log(error);
            })
    }

    render() {
        return (
            <Fragment>
                <Header />
                {this.state.fetchInProgress &&
                    <LoadingSpinner />
                }
                <main className="my-5 py-5 mx-2 px-2">
                    <div>
                        <Row noGutters className="pt-2 pt-md-2 w-100 px-4 px-xl-0 position-relative">
                            <Col xs={{ order: 2 }} md={{ size: 10, order: 2 }} tag="section" className="py-5 mb-5 py-md-0 mb-md-0">
                                   <NorData norData={this.state.norData} />
                            </Col>
                        </Row>
                    </div>
                </main>
            </Fragment>
        );
    }
}

export default MainPage;
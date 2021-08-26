import React from 'react';

var SearchFacet = React.createClass({
  handleChange: function() {
    this.props.onUserInput(
      this.refs.searchStringInput.value
    )
  },
  render: function() {
    return (
      <div>
        Search for:
        <input
          type="text"
          defaultValue={this.props.searchString}
          ref="searchStringInput"
          onChange={this.handleChange} />
      </div>
    );
  }
});

var SearchTool = React.createClass({
  render: function() {
    return (
      <form>
        <SearchFacet 
          searchString={this.props.searchString}
          onUserInput={this.props.onUserInput}
         />
        <button>Search</button>
      </form>
    );
  }
});

var Searcher = React.createClass({
  getInitialState: function() {
    return {
      searchString: ''
    }
  },

  handleUserInput: function(searchString) {
    this.setState({
      searchString: searchString
    })
  },

  render: function() {
    return (
      <div>
        <SearchTool 
          searchString={this.state.searchString}
          onUserInput={this.handleUserInput}
        />
      </div>
    );
  }
});

export default Searcher;
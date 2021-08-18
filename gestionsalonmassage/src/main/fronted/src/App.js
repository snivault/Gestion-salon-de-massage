import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import reactjs, { useState, useEffect } from "react";

const Clients = () => {
  const fetchClients = () => {
    axios.get("http://localhost:8081/clients").then(res => {
      console.log(res);
    }
    );
  }

  useEffect(() => {fetchClients();},[])

  return <h1>Hello</h1>;
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Hello Gestion salon de massage
        </a>
      </header>
      <body><Clients></Clients></body>
    </div>
  );
}

export default App;

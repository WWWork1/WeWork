import './App.css';
import Header from './Components/Header';
import Menu from './Components/Menu';
import Home from './Components/Home';
function App() {
  return (
    <div className="App">
      
      <Header />
      <div className="app-container">
        <div className="fixed-column">
          <Menu/>
        </div>
        <div className="dynamic-column">
         <Home/>
        </div>
      </div>
      
    </div>
  );
}

export default App;

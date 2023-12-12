import { useState } from "react";
import Button from "react-bootstrap/Button";

const OffcanvasFooter = () => {  
  return (
    <div style={{ fontSize: 12 }}>
      <h1 className="font-mono text-blue-400 text-sm">Created with <span className="text-pink-400 italic">love💖💖💖</span> by :</h1>
    <Button 
      style={{ textDecoration: 'none' }}
      variant="link" 
      size="sm" 
      onClick={() => window.open('https://github.com/luvluvdt3')}
    >👩‍💻 Tu</Button>
     <Button 
      style={{ textDecoration: 'none' }}
      variant="link" 
      size="sm" 
      onClick={() => window.open('https://github.com/BadUkrainianWolf')}
    >👩🏻‍💻 Mariaa</Button>
    <br />
  </div>
  )
}

export default OffcanvasFooter;

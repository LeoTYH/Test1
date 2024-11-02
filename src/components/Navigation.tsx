import React from 'react';

export default function Navigation() {
  return (
    <nav>
      <div className="nav-content">
        <a href="/" className="site-title">Belinda</a>
        <div className="nav-links">
          <a href="/">Home</a>
          <a href="/about">About</a>
          <a href="/contact">Contact</a>
        </div>
      </div>
    </nav>
  );
}
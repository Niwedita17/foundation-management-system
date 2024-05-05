import React, { useState } from 'react';
import axios from 'axios';

const NonprofitForm = () => {
  const [name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/nonprofits', { name, address, email });
      alert('Nonprofit created successfully!');
      // Reset form fields after successful submission
      setName('');
      setAddress('');
      setEmail('');
    } catch (error) {
      console.error('Error creating nonprofit:', error);
      alert('Failed to create nonprofit. Please try again.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </label>
      <label>
        Address:
        <input type="text" value={address} onChange={(e) => setAddress(e.target.value)} />
      </label>
      <label>
        Email:
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default NonprofitForm;

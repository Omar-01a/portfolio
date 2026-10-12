import { useState } from "react"

function Navbar() {

  const [isOpen, setIsOpen] = useState(false)

  const closeMenu = () => {
    setIsOpen(false)
  }

  return (
    <nav className="fixed top-0 z-50 w-full border-b border-white/10 bg-black/80 backdrop-blur">

      <div className="mx-auto flex max-w-6xl items-center justify-between px-6 py-4">

        {/* Logo */}
        <a
          href="#home"
          onClick={closeMenu}
          className="text-xl font-bold"
        >
          Omar Alabdullatif<span className="text-gray-500">.</span>
        </a>


        {/* Desktop Menu */}
        <div className="hidden gap-8 md:flex">

          <a href="#home" className="text-gray-400 transition hover:text-white">
            Home
          </a>

          <a href="#about" className="text-gray-400 transition hover:text-white">
            About
          </a>

          <a href="#skills" className="text-gray-400 transition hover:text-white">
            Skills
          </a>

          <a href="#projects" className="text-gray-400 transition hover:text-white">
            Projects
          </a>

          <a href="#experience" className="text-gray-400 transition hover:text-white">
            Experience
          </a>

          <a
            href="#certifications"
            className="text-gray-400 transition hover:text-white"
          >
            Certifications
          </a>

          

        </div>


        {/* Desktop Contact Button */}
        <a
          href="#contact"
          className="hidden rounded-lg border border-white/20 px-4 py-2 text-sm transition hover:bg-white hover:text-black md:block"
        >
          Contact Me
        </a>


        {/* Mobile Menu Button */}
        <button
          onClick={() => setIsOpen(!isOpen)}
          className="rounded-lg border border-white/20 px-3 py-2 text-sm md:hidden"
        >
          {isOpen ? "Close" : "Menu"}
        </button>

      </div>


      {/* Mobile Menu */}
      {isOpen && (
        <div className="border-t border-white/10 bg-black px-6 py-6 md:hidden">

          <div className="flex flex-col gap-5">

            <a
              href="#home"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Home
            </a>

            <a
              href="#about"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              About
            </a>

            <a
              href="#skills"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Skills
            </a>

            <a
              href="#projects"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Projects
            </a>

            <a
              href="#experience"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Experience
            </a>

            <a
              href="#certifications"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Certifications
            </a>

               <a
              href="#contact"
              onClick={closeMenu}
              className="text-gray-400 transition hover:text-white"
            >
              Contact
              
            </a>

           

          </div>

        </div>
      )}
      

    </nav>

  ) 
}

export default Navbar
import { useEffect, useState } from "react"
import type { Project } from "../types/Project"

function Projects() {

  const [projects, setProjects] = useState<Project[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {

    fetch("http://localhost:8080/api/projects")
      .then((response) => response.json())
      .then((data: Project[]) => {
        setProjects(data)
        setLoading(false)
      })
      .catch((error) => {
        console.error("Error fetching projects:", error)
        setLoading(false)
      })

  }, [])

  return (
    <section id="projects" className="px-6 py-24">

      <div className="mx-auto max-w-6xl">

        <p className="mb-3 text-sm uppercase tracking-[0.3em] text-gray-500">
          Projects
        </p>

        <h2 className="text-4xl font-bold md:text-5xl">
          Things I've built.
        </h2>

        {loading && (
          <p className="mt-12 text-gray-500">
            Loading projects...
          </p>
        )}

        {!loading && projects.length === 0 && (
          <p className="mt-12 text-gray-500">
            No projects available.
          </p>
        )}

        <div className="mt-12 grid gap-6 md:grid-cols-2">

          {projects.map((project) => (

            <article
              key={project.id}
              className="rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:border-white/20 hover:bg-white/[0.05]"
            >

              <p className="text-sm uppercase tracking-wide text-gray-500">
                {project.category}
              </p>

              <h3 className="mt-3 text-2xl font-bold">
                {project.title}
              </h3>

              <p className="mt-4 leading-7 text-gray-400">
                {project.description}
              </p>

              <div className="mt-6 flex gap-3">

                {project.githubUrl && (
                  <a
                    href={project.githubUrl}
                    target="_blank"
                    rel="noreferrer"
                    className="rounded-lg border border-white/20 px-4 py-2 text-sm transition hover:bg-white hover:text-black"
                  >
                    GitHub
                  </a>
                )}

                {project.liveUrl && (
                  <a
                    href={project.liveUrl}
                    target="_blank"
                    rel="noreferrer"
                    className="rounded-lg bg-white px-4 py-2 text-sm text-black transition hover:bg-gray-200"
                  >
                    Live Demo
                  </a>
                )}

              </div>

            </article>

          ))}

        </div>

      </div>

    </section>
  )
}

export default Projects